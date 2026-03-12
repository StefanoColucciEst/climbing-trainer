import { Dumbbell } from 'lucide-react'

export function TrainingPage() {
  return (
    <div className="pt-12 text-center">
      <div className="w-16 h-16 bg-gray-100 rounded-full flex items-center justify-center mx-auto mb-4">
        <Dumbbell className="w-8 h-8 text-text-secondary" />
      </div>
      <h1 className="text-2xl font-bold text-text">Training</h1>
      <p className="text-text-secondary mt-2">Coming soon</p>
    </div>
  )
}
