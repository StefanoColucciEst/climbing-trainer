import { useQuery } from '@tanstack/react-query'
import { getConditioning, getProfile } from '../api/client'

export function useConditioning() {
  return useQuery({ queryKey: ['conditioning'], queryFn: getConditioning })
}

export function useProfile() {
  return useQuery({ queryKey: ['profile'], queryFn: getProfile })
}
