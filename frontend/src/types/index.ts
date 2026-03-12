export type GripCategory = 'HANG' | 'LIFT'
export type HandMode = 'SINGLE_HAND' | 'TWO_HANDS'
export type Finger = 'THUMB' | 'INDEX' | 'MIDDLE' | 'RING' | 'PINKY'
export type GripType = 'HALF_CRIMP' | 'FULL_CRIMP' | 'OPEN_HAND' | 'THREE_FINGER_DRAG' | 'PINCH' | 'MONO' | 'POCKET'
export type EdgeType = 'FLAT' | 'UNEVEN'
export type AssessmentType = 'MAX_STRENGTH_7S' | 'POWER_ENDURANCE_60PCT' | 'ENDURANCE_30PCT_HANG' | 'MAX_STRENGTH_1RM' | 'ENDURANCE_30PCT_LIFT' | 'CUSTOM'
export type ConditioningType = 'PULLUP_1RM' | 'PULLUP_MAX_REPS' | 'CAMPUS_BOARD'

export interface Grip {
  id: number
  name: string
  category: GripCategory
  handMode: HandMode
  fingers: Finger[]
  gripType: GripType
  edgeDepthMm: number
  edgeType: EdgeType
}

export interface AssessmentEntry {
  id: number
  resistanceKg: number | null
  bodyWeightPct: number | null
  resistanceLeftKg: number | null
  resistanceRightKg: number | null
  bodyWeightPctLeft: number | null
  bodyWeightPctRight: number | null
  numberOfHangs: number | null
  timeUnderTensionSeconds: number | null
  bodyWeightKg: number | null
  recordedAt: string
}

export interface Assessment {
  id: number
  gripId: number
  assessmentType: AssessmentType
  customName: string | null
  entries: AssessmentEntry[]
}

export interface ConditioningEntry {
  id: number
  resistanceKg: number | null
  bodyWeightPct: number | null
  maxReps: number | null
  bodyWeightKg: number | null
  recordedAt: string
}

export interface ConditioningExercise {
  id: number
  name: string
  conditioningType: ConditioningType
  entries: ConditioningEntry[]
}

export interface UserProfile {
  id: number
  name: string
  bodyWeightKg: number
  streakDays: number
}
