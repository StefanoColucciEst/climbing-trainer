import axios from 'axios'
import type { Grip, Assessment, ConditioningExercise, UserProfile } from '../types'

const api = axios.create({ baseURL: '/api/v1' })

// Grips
export const getGrips = () => api.get<Grip[]>('/grips').then(r => r.data)
export const getGrip = (id: number) => api.get<Grip>(`/grips/${id}`).then(r => r.data)
export const createGrip = (data: Omit<Grip, 'id'>) => api.post<Grip>('/grips', data).then(r => r.data)
export const updateGrip = (id: number, data: Omit<Grip, 'id'>) => api.put<Grip>(`/grips/${id}`, data).then(r => r.data)
export const deleteGrip = (id: number) => api.delete(`/grips/${id}`)

// Assessments
export const getAssessments = (gripId: number) =>
  api.get<Assessment[]>(`/grips/${gripId}/assessments`).then(r => r.data)
export const createAssessment = (gripId: number, data: { assessmentType: string; customName?: string }) =>
  api.post<Assessment>(`/grips/${gripId}/assessments`, data).then(r => r.data)
export const addAssessmentEntry = (gripId: number, assessmentId: number, data: Record<string, number | null>) =>
  api.post(`/grips/${gripId}/assessments/${assessmentId}/entries`, data).then(r => r.data)

// Conditioning
export const getConditioning = () => api.get<ConditioningExercise[]>('/conditioning').then(r => r.data)
export const createConditioning = (data: { name: string; conditioningType: string }) =>
  api.post<ConditioningExercise>('/conditioning', data).then(r => r.data)
export const addConditioningEntry = (id: number, data: Record<string, number | null>) =>
  api.post(`/conditioning/${id}/entries`, data).then(r => r.data)

// Profile
export const getProfile = () => api.get<UserProfile>('/profile').then(r => r.data)
export const updateProfile = (data: { name?: string; bodyWeightKg?: number }) =>
  api.put<UserProfile>('/profile', data).then(r => r.data)
